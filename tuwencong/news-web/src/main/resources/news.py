# -*- coding: utf-8 -*-
"""
Created on Mon Jun 05 14:01:23 2017

@author: tuwen
"""

import re
import bs4
import urllib2  
import MySQLdb
from bs4 import BeautifulSoup

connect=MySQLdb.connect(host="localhost",user="root",passwd="root",db="pachong",charset="utf8")    
cursor = connect.cursor() 

# 文章类定义
class Article(object):
    def __init__(self):
        self.url = None
        self.title = None
        self.source = None
        self.date = None
        #self.summary = None
        self.content = None
        

def read_url():
    url_old = set()  # 过期url
    sql = 'select url from url_old'
    cursor.execute(sql)
    connect.commit()   
    rows = cursor.fetchall()
    for row in rows:
        row = row[0].encode('utf-8')
        url_old.add(row)
    return url_old

def write_url(url_old_temp):
    #print len(url_old_temp)
    for url in url_old_temp:
        sql = 'INSERT INTO url_old(url)'
        sql = sql + " VALUES ('%s') "
        data = (url)
        cursor.execute(sql % data)
        connect.commit() 
        
def check_url(links,url_old):
    url_set = set()  # url集合  
    for link in links:
        link = 'http:' + link[7:-2]
        if link not in url_old:
            #print link
            url_set.add(link)
    return url_set
            


def write_sql(News_Type,News):
    sql = 'INSERT INTO ' + News_Type + '( url, title, source, date, content )'
    sql = sql + " VALUES ('%s', '%s', '%s', '%s', '%s') "
    data = (News.url, News.title, News.source, News.date, News.content)
    cursor.execute(sql % data)
    connect.commit()
            
    
    
        
def download_html(News_Type,News_Type_CN):      
    url_old = read_url()
    print len(url_old)

    home = 'http://search.cebnet.com.cn/getjsonp?q=' + News_Type_CN + '&p=1&callback=jsonpCallback&_=1497334188283'
    home_headers = {'User-Agent':'Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.1.6) Gecko/20091201 Firefox/3.5.6'}   
    home_request = urllib2.Request(url = home, headers = home_headers) 
    home_response  = urllib2.urlopen(home_request)
    home_html = home_response.read()
    links = re.findall(r'"url":".*?"}', home_html)
        
    url_set = check_url(links,url_old)    
    #print len(url_set)   
    url_old_temp = set() 
    
    while len(url_set) != 0:
        try:
            #print len(url_set)
            url = url_set.pop()
            #print url
            url_old_temp.add(url)
        
            request = urllib2.Request(url)  
            response = urllib2.urlopen(request)  
            html = response.read()  
            soup = BeautifulSoup(html,'html.parser')  
    
            News = Article()
    
            News.url = url
            News_title_temp = soup.find('div', {'class': 'w835 fl'})
            if News_title_temp is None:
                News.title = soup.find('div', {'class': 'txt-title'}).h2.get_text().encode('utf-8')
                News.source = soup.find('div', {'class': 'txt-time'}).find_all('dd')[1].string.encode('utf-8')
                News.date = soup.find('div', {'class': 'txt-time'}).find_all('dd')[0].string.encode('utf-8')
                News_content_temp = ''
                pnode = soup.find('div', {'class': 'txt-cont txt-cont1'}).find_all('p')
                for node in pnode:
                    if (node.get_text() != ''):
                        News_content_temp += node.get_text() + '<br>'                 
                News.content = News_content_temp.encode('utf-8')
            else:
                News.title = News_title_temp.h1.get_text().encode('utf-8')
                News.source = soup.find('span', {'class': 'comfrom'}).get_text().encode('utf-8')
                News.date = soup.find('span', {'class': 'time'}).get_text().encode('utf-8')
                News_content_temp = ''
                pnode = soup.find('div', {'class': 'content'}).find_all('p')
                for node in pnode:
                    if (node.get_text() != ''):
                        News_content_temp += node.get_text() + '<br>'
                News.content = News_content_temp.encode('utf-8')
            #News.summary = soup.find('div', {'class': 'summary'}).get_text().encode('utf-8')
                        
            write_sql(News_Type,News)
        
        except Exception as e:
            print(e)
            continue

    write_url(url_old_temp)
    
    
def download_other_html(News_Type,News_Type_CN):
    url_old = read_url()
    print len(url_old)
    
    home = 'https://www.leiphone.com/tag/' + News_Type_CN
    home_headers = {'User-Agent':'Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.1.6) Gecko/20091201 Firefox/3.5.6'}   
    home_request = urllib2.Request(url = home, headers = home_headers) 
    home_response  = urllib2.urlopen(home_request)
    home_html = home_response.read()
    soup = BeautifulSoup(home_html,'html.parser') 
       
    url_set = set()  # url集合
    for h3 in soup.findAll('h3'):
        for a in h3.findAll('a',href=True):
            link = str(a['href'])
            #print type(link)
            #print link
            if link not in url_old:
                url_set.add(link)  
    #print len(url_set)    
    url_old_temp = set() 
    
    while len(url_set) != 0:
        try:
            #print len(url_set)
            url = url_set.pop()
            print url
            url_old_temp.add(url)
            
            
            #print 'x'                      
            headers = {'User-Agent':'Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.1.6) Gecko/20091201 Firefox/3.5.6'}          
            request = urllib2.Request(url, headers = headers)  
            response = urllib2.urlopen(request)  
            html = response.read()  
            soup = BeautifulSoup(html,'html.parser')  
                          
            News = Article()
    
            News.url = url
            News.title = soup.find('h1', {'class': 'headTit'}).get_text().encode('utf-8').lstrip().rstrip()
            #print News.title
            News.source = '雷锋网'
            News.date = soup.find('td', {'class': 'time'}).get_text().encode('utf-8').lstrip().rstrip()
            News_content_temp = ''
            pnode = soup.find('div', {'class': 'lph-article-comView'}).find_all('p')
            for node in pnode:
                if (node.get_text() != ''):
                    News_content_temp += '　　' + node.get_text().encode('utf-8') + '<br>'                 
            News.content = News_content_temp
            
            write_sql(News_Type,News)
        
        except Exception as e:
            print(e)
            continue
    write_url(url_old_temp)

if __name__ == '__main__':
    News_Dashuju = 'News_Bigdata'
    News_Dashuju_CN = '大数据'   
    
    News_Rengongzhineng = 'News_AI'
    News_Rengongzhineng_CN = '智能'
    
    News_Qukuailian = 'News_Blockchain'
    News_Qukuailian_CN = '区块链'   
    
    
    News_Qita = 'News_Other'
    News_Qitan_CN_1 = '大数据'
    News_Qitan_CN_2 = '保险'
    News_Qitan_CN_3 = '数据分析'
    
    download_html(News_Dashuju,News_Dashuju_CN)
    download_html(News_Rengongzhineng,News_Rengongzhineng_CN)
    download_html(News_Qukuailian,News_Qukuailian_CN)
    
    
    download_other_html(News_Qita,News_Qitan_CN_1)
    download_other_html(News_Qita,News_Qitan_CN_2)
    download_other_html(News_Qita,News_Qitan_CN_3)
    
    
    


    
    
    
    
