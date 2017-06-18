# -*- coding: utf-8 -*-
"""
Created on Wed Jun 07 16:32:19 2017

@author: tuwen
"""

from bottle import template, route, run, template  
import MySQLdb



def newspages(Table_Name):
    conn=MySQLdb.connect(host='localhost',user='root',passwd='root',db='pachong',charset='utf8')    
    cursor = conn.cursor()      
    cursor.execute('SELECT * from (SELECT * FROM %s order by date DESC) t1 limit 5' %Table_Name)
    
    rows = cursor.fetchall()
    
    Table_Name_Title = []
    
    
    
    
    for i in range(len(rows)):
        row = list(rows[i])
        tittle = row[2].encode('utf-8')
        content = row[5].encode('utf-8')
        
        
        
        News_Html = """
        <html>
        <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <h2>%s</h2>
        </head>
        <body>
        <p>%s</p>
        <p><a href=menu.html>首页</a></p>
        </body>
        </html>"""%(tittle,content)


        Number = str(i)
        
        html_name = Table_Name + Number + '.html'
        
        with open(Table_Name + Number + '.html','wb') as f:
            f.write(News_Html)
        
        
            
        Table_Name_Title.append((tittle , html_name ))
    return Table_Name_Title
    
    

        
def menu(Dashuju_Link,Rengongzhineng_Link,Qukuailian_Link,Qita_Link):
    template_demo="""
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <h2>金融科技新闻</h2></head>
    <body>
    % for title,link in Qita:
        <a href={{link}}>{{title}}</a>
        <br>
    %end
    <hr />
    
    <h2>区块链新闻</h2></head>
    <body>
    % for title,link in Qukuailian:
        <a href={{link}}>{{title}}</a>
        <br>
    %end
    <hr />
    
    <h2>大数据新闻</h2></head>
    <body>
    % for title,link in Dashuju:
        <a href={{link}}>{{title}}</a>
        <br>
    %end
    <hr />
    
    <h2>人工智能新闻</h2></head>
    <body>
    % for title,link in Rengongzhineng:
        <a href={{link}}>{{title}}</a>
        <br>
    %end
    <hr />
    
    </body
    </html>
    """
    html = template(template_demo, Dashuju = Dashuju_Link, Rengongzhineng = Rengongzhineng_Link, Qukuailian = Qukuailian_Link, Qita = Qita_Link)
    with open("menu.html",'wb') as f:
        f.write(html.encode('utf-8'))



if __name__ == '__main__':
    Dashuju_News_Table = 'News_Bigdata'
    Rengongzhineng_News_Table = 'News_AI'
    Qukuailian_News_Table = 'News_Blockchain'
    Qita_News_Table = 'News_Other'

    Dashuju_Link = newspages(Dashuju_News_Table)
    Rengongzhineng_Link = newspages(Rengongzhineng_News_Table)
    Qukuailian_Link = newspages(Qukuailian_News_Table)
    Qita_Link = newspages(Qita_News_Table)
    menu(Dashuju_Link,Rengongzhineng_Link,Qukuailian_Link,Qita_Link)
    
    
'''
@route('/hello')
def hello():
  return open('menu.html','r')
run() # This starts the HTTP server
'''    
    
    
    