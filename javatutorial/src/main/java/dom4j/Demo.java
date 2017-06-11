package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by zhaoyi on 17-6-9.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Document doc = DocumentHelper.createDocument();
        //增加根节点
        Element policy = doc.addElement("policy");
        //增加子元素
        Element policyNumber = policy.addElement("policyNumber");//保单号
        Element productName = policy.addElement("productName");//保险产品名称
        Element phName = policy.addElement("phName");//投保人
        Element phGender = policy.addElement("phGender");//性别
        Element phBirthday = policy.addElement("phBirthday");//出生日期
        Element phMobile = policy.addElement("phMobile");//手机号码
        Element phIdType = policy.addElement("phIdType");//证件类型
        Element phIdNumber = policy.addElement("phIdNumber");//证件号码

        Element piName = policy.addElement("piName");//被保人
        Element piGender = policy.addElement("piGender");//被保人性别
        Element piBirthday = policy.addElement("piBirthday");//被保人出生日期
        Element piMobile = policy.addElement("piMobile");//被保人手机号码
        Element piIdType = policy.addElement("piIdType");//被保人证件类型
        Element piIdNumber = policy.addElement("piIdNumber");//被保人证件号码
        Element relationWithPH = policy.addElement("relationWithPH");//被保人与投保人关系

        Element policyPoi = policy.addElement("policyPoi");//保险期间
        Element premium = policy.addElement("premium");//保险费
        Element cnPremium = policy.addElement("cnPremium");//保险费中文大写


        policyNumber.setText("86320020070210241042");
        productName.setText("e生无忧百万医疗保险");
        phName.setText("王丹丹");
        phGender.setText("女");
        phBirthday.setText("1990-10-10");
        phMobile.setText("13609891929");
        phIdType.setText("身份证");
        phIdNumber.setText("310130199010102310");

        piName.setText("王丹丹");
        piGender.setText("女");
        piBirthday.setText("1990-10-10");
        piMobile.setText("13609891929");
        piIdType.setText("身份证");
        piIdNumber.setText("310130199010102310");
        relationWithPH.setText("本人");

        policyPoi.setText("自2017年06月06日零时起至2018年06月05日二十四时止");
        premium.setText("372.00");
        cnPremium.setText("叁佰柒拾贰圆整");


        //实例化输出格式对象
        OutputFormat format = OutputFormat.createPrettyPrint();
        //设置输出编码
        format.setEncoding("UTF-8");
        //创建需要写入的File对象
        File file = new File("/home/zhaoyi/policy.xml");
        //生成XMLWriter对象，构造函数中的参数为需要输出的文件流和格式
        XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
        //开始写入，write方法中包含上面创建的Document对象
        writer.write(doc);
    }
}
