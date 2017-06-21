package sequence;


public class TMContConstant {

	 /*********************************BASEINFO--������ϢԪ����������******************************************************/
    public static final String XML_BASEINFO = "BaseInfo"; //������Ϣ
    public static final String XML_MANAGECOM = "ManageCom"; //�����������

    public static final String XML_CONTNO = "ContNo"; //Ͷ������
    public static final String XML_HIGHAMNTFLAG = "HighAmntFlag"; //�Ƿ�߶��
    public static final String XML_HEALTHIMPARTFLAG = "HealthImpartFlag"; //�Ƿ���д������֪
    public static final String XML_OCCPUIMPARTFLAG = "OccpuImpartFlag"; //�Ƿ���дְҵ��֪
    public static final String XML_FINIMPARTFLAG = "FinImpartFlag"; //�Ƿ���д�����֪

    public static final String XML_FLAG = "Flag"; //�̶�0���ǿ�<!-- ϵͳ��Ҫ�����ر�ʶ�� 0-���� 1-�쳣�����ǿ�-->
     /**********************************BASEINFO--������ϢԪ�������������******************************************************/
   
    /**********************************������ϢԪ����������******************************************************/
    public static final String XML_ERRORS = "Errors";
    public static final String XML_ERROR = "Error";
    public static final String XML_ERRTYPE = "ErrType"; //NEW
    public static final String XML_ERRTAG = "ErrTag";
    public static final String XML_ERRCODE = "ErrCode";
    public static final String XML_ERRMESSAGE = "ErrMessage";
    /**********************************������ϢԪ�������������******************************************************/
    
    /**********************************LCCONT--������ϢԪ����������******************************************************/
    public static final String XML_CONTINFO = "ContInfo";
    public static final String XML_LCCONT = "LCCont"; //������Ϣ
                                                       //contno��baseinfo�Ѿ�����
    public static final String XML_PRTNO = "PrtNo"; //ӡˢ��
    public static final String XML_POLAPPLYDATE = "PolApplyDate"; //Ͷ����Ͷ������
    public static final String XML_POLAPPLYTIME = "PolApplyTime"; //Ͷ����Ͷ�����ڵľ���ʱ��---���������ӵ��ֶ�
    public static final String XML_AGENTCODE = "AgentCode"; //��ҵ��Ա����(���ҵ��Աʱ����ҵ��Ա)
    public static final String XML_AGENTNAME = "AgentName"; //ҵ��Ա����(���ҵ��Աʱ����ҵ��Ա)
    public static final String XML_AGENTCOM = "AgentCom"; //��ҵ��Ա���д������(���ҵ��Աʱ����ҵ��Ա)
    public static final String XML_AGENTCOMNAME = "AgentComName"; //��ҵ��Ա���д����������(���ҵ��Աʱ����ҵ��Ա) add by huqiang
    public static final String XML_MANAGECOM2 = "ManageCom"; //�����������
    public static final String XML_CONTPLANCODE = "ContPlanCode"; //��Ʒ������ϣ������ת��
    public static final String XML_SALECHNL = "SaleChnl"; //��������(�̶�Ϊ13)

		
	public static final String XML_XQREMINDFLAG = "XQREMINDFLAG"; //���ڽɷ���ʾ
    public static final String XML_AGENTGROUP = "AgentGroup"; //��ҵ��Ա���(���ҵ��Աʱ����ҵ��Ա)
    public static final String XML_AGENTRELATOAPPNT = "AgentRelatoAppnt"; //��ҵ��Ա��Ͷ���˵Ĺ�ϵ(���ҵ��Աʱ����ҵ��Ա)
    public static final String XML_CVALIDATE = "CvaliDate"; //��Ч����
    public static final String XML_FORCEUWFLAG = "Forceuwflag";
    public static final String XML_FORCEUWREASON = "Forceuwreason";
    
    public static final String XML_PAYMODE = "PayMode"; //���ڽɷ�
    public static final String XML_BANKCODE = "BankCode"; //Ͷ������Ȩת�ʿ������У������ת��
    public static final String XML_BANKACCNO = "BankAccNo"; //�����ʺ�
    public static final String XML_ACCNAME = "AccName"; //�����ʻ���
    public static final String XML_REMARK = "Remark"; //Ͷ������������(��ע)
    public static final String XML_NOTICE = "Notice"; //�� 	<!--	Ͷ�������ݣ����չ�˾������ѡ���������ת��-->
    
    public static final String XML_PAYLOCATION = "PayLocation"; //���ڽ���λ�û�ʽ(������ת�ʡ����н��ɡ����Ž��ѵ�)
    public static final String XML_REBANKCODE = "ReBankCode"; //���ڽ������б�� 
    public static final String XML_REBANKACCNO = "ReBankAccNo"; //���ڽ����ʺ� 
    public static final String XML_REACCNAME = "ReAccName"; //���ڽ����ʻ��� 
    public static final String XML_AGENTBANKCODE = "AgentBankCode"; //�����������(���ݴ˴��룬���Ҵ������������ר��Ա��Ϣ)
    public static final String XML_BANKAGENT = "BankAgent"; //������Ա����

    public static final String XML_PREM = "Prem"; //�ϼƱ��շ� 
    public static final String XML_IMPARTQUESTION = "ImpartQuestion"; //��֪��Ϣ�Ƿ�׷��ֽ�ţ���ѡ����Y������ѡ����N 
    public static final String XML_APPNTSIGN = "AppntSign";//Ͷ����ǩ�� 
    public static final String XML_INSUREDSIGN = "InsuredSign";//��������ǩ�� 
    public static final String XML_GUARDIANSIGN = "GuardianSign";//δ�����˷����໤��ǩ�� 

   /**********************************LCCONT--������ϢԪ�������������********************************/

   /**********************************Agents-ҵ��Ա��Ϣ��������************************************/
    public static final String XML_AGENTS = "Agents";
    public static final String XML_AGENTCOUNT = "AgentCount"; //ҵ��Ա����
    public static final String XML_AGENT = "Agent"; //ҵ��Ա

    //ҵ��ԱԪ�ؽ����Ϣ��������
    //AGENTCODE,AGENTCOM,AGENTNAME,MANAGECOM��AGENTGROUP,AgentRelatoAppnt������ж�����
     public static final String XML_BUSIRATE = "Busirate"; //ҵ��Ա��Ӷ����

    /**********************************Agents-ҵ��Ա��Ϣ��������************************************/

    /**********************************LCAPPNT-Ͷ������Ϣ��������************************************/
    public static final String XML_LCAPPNT = "LCAppnt"; //Ͷ������Ϣ
    public static final String XML_APPNTNAME = "AppntName"; //Ͷ��������
    public static final String XML_APPNTSEX = "AppntSex"; //Ͷ�����Ա�
    public static final String XML_APPNTBIRTHDAY = "AppntBirthday"; //Ͷ��������
    public static final String XML_APPRELATIONTOINSURED = "RelationToInsured"; //������ǩ��Ͷ�����뱻���˵Ĺ�ϵ��
    public static final String XML_APPNTIDTYPE = "AppntIDType"; //Ͷ����֤������
    public static final String XML_APPNTIDNO = "AppntIDNo"; //Ͷ����֤������
    public static final String XML_APPNTIDEXPDATE = "AppntIDExpDate"; //Ͷ����֤����Ч��
    public static final String XML_MARRIAGE = "Marriage"; //Ͷ���˻���״��
    public static final String XML_MARRYDATE = "MarryDate"; //Ͷ���˽������� 
    public static final String XML_NATIVEPLACE = "NativePlace"; //Ͷ���˹���
    public static final String XML_DEGREE = "DeGree"; //ѧ���������ת�� 
    public static final String XML_STATURE = "Stature"; //Ͷ�������(cm) 
    public static final String XML_AVOIRDUPOIS = "Avoirdupois"; //Ͷ��������(kg) 
    public static final String XML_WORKTYPE = "WorkType"; //Ͷ����ְҵ/���� 
    public static final String XML_POSITION = "Position"; //Ͷ����ְ�� 
    public static final String XML_PLURALITYTYPE = "PluralityType"; //Ͷ���˼�ְ/���� 
    public static final String XML_OCCUPATIONCODE = "OccupationCode";// Ͷ�������ְҵ����
    public static final String XML_OCCUPATIONTYPE = "OccupationType";// Ͷ����ְҵ�����ְҵ����ת������
    public static final String XML_APPSOCIALFLAG = "AppSocialFlag";// �� ����ҽ�Ʊ��

    public static final String XML_NATIONALITY = "Nationality"; //Ͷ��������
    public static final String XML_LICENSE = "License"; //Ͷ���˼���
    public static final String XML_LICENSETYPE = "LicenseType"; //Ͷ���˼�������


    //��ַ��Ϣ
    public static final String XML_LCADDRESS = "LCAddress"; //��ַ��Ϣ
    public static final String XML_PROVINCE = "Province"; //ͨѶ��ַ��ʡ��
    public static final String XML_CITY = "City"; //ͨѶ��ַ(��)
    public static final String XML_COUNTY = "County"; //ͨѶ��ַ(��/��)
    public static final String XML_POSTALADDRESS = "PostalAddress"; //ͨѶ��ַ(�ֵ�)
    public static final String XML_ZIPCODE = "ZipCode"; //ͨѶ��������
    public static final String XML_HOMEADDRESS = "HomeAddress"; //ס����ַ��Ϣ
    public static final String XML_HOMEZIPCODE = "HomeZipCode"; //ס����������

    public static final String XML_MOBILE = "Mobile"; //�ƶ��绰
    public static final String XML_COMPANYPHONE = "CompanyPhone"; //�칫�绰
    public static final String XML_HOMEPHONE = "HomePhone"; //סլ�绰
    public static final String XML_PHONE = "Phone"; //��ϵ�绰
    public static final String XML_GRPNAME = "GrpName"; //��λ����
    public static final String XML_EMAIL = "Email"; //��������
    public static final String XML_FAX = "Fax"; //����绰
    public static final String XML_COMPANYADDRESS = "CompanyAddress"; //��λ��ַ

    /**********************************LCAPPNT-Ͷ������Ϣ�����������***********************************/

    /**********************************LCINSURED-��������Ϣ�����������*********************************/
    public static final String XML_LCINSUREDS = "LCInsureds"; //��������Ϣ
    public static final String XML_LCINSUREDCOUNT = "LCInsuredCount"; //��������Ŀ
    public static final String XML_LCINSURED = "LCInsured"; //
    public static final String XML_NAME = "Name"; //����������
    public static final String XML_SEX = "Sex"; //�������Ա�
    public static final String XML_BIRTHDAY = "Birthday"; //����������
    public static final String XML_IDTYPE = "IDType"; //������֤������
    public static final String XML_IDNO = "IDNo"; //������֤������
    public static final String XML_INSUIDEXPDATE = "InsuIDExpDate"; //������֤����Ч��

    public static final String XML_RELATIONTOAPPNT = "RelationToAppnt"; //  ��Ͷ���˹�ϵ
    public static final String XML_RELATIONTOMAININSURED =
            "RelationToMainInsured"; //���������˹�ϵ

    public static final String XML_SEQUENCENO = "SequenceNo"; //���������
    public static final String XML_INSUSOCIALFLAG = "InsuSocialFlag"; //�����˹���ҽ�Ʊ��

    //�����˸�֪
    public static final String XML_LCINSUREIMPARTS = "LCInsureImparts"; //�����˸�֪
    public static final String XML_LCINSUREDIMPARTCOUNT =
            "LCInsureImpartCount"; //�����˸�֪��Ŀ
    public static final String XML_LCINSUREIMPART = "LCInsureImpart"; //
    public static final String XML_IMPARTVERSION = "ImpartVersion"; //��֪���
    public static final String XML_IMPARTCODE = "ImpartCode"; //��֪����
    public static final String XML_IMPARTCONTENT = "ImpartContent"; //��֪����
    public static final String XML_IMPARTPARAMMODLE = "ImpartParammodle"; //��֪����
    /**********************************LCINSURED-Ͷ������Ϣ�����������**************************************/

    /**********************************LCPOL-������Ϣ��������*********************************/
    public static final String XML_RISKS = "Risks"; //������Ϣ
    public static final String XML_RISKCOUNT = "RiskCount"; //������Ŀ
    public static final String XML_RISK = "Risk"; //
    public static final String XML_RISKCODE = "RiskCode"; //���ֱ���
    public static final String XML_MAINRISKCODE = "MainRiskCode"; //���ֱ���
    public static final String XML_AMNT = "Amnt"; //����
    //public static final String XML_PREM = "Prem"; //����
    public static final String XML_MULT = "Mult"; //����
    public static final String XML_PAYINTV = "PayIntv"; //�ɷѼ��
    public static final String XML_YEARS = "Years"; //��������
    public static final String XML_INSUYEARFLAG = "InsuYearFlag"; //�������������־
    public static final String XML_INSUYEAR = "InsuYear"; //������������
    public static final String XML_PAYENDYEARFLAG = "Payendyearflag"; //�������ڱ�־
    public static final String XML_PAYENDYEAR = "Payendyear"; //��������
    public static final String XML_AUTOPAYFLAG = "AutoPayFlag"; //�潻��־
    public static final String XML_SURVIVEPAYFLAG = "SurvivePayFlag"; //����𷵻����ֽ����ѱ�־�������ת�� 
    public static final String XML_BONUSPAYMODE = "BonusPayMode"; //����������
    public static final String XML_INVESTFLAG = "InvestFlag"; //�գ���ԥ�����ʽ��Ƿ����Ͷ�ʱ�־��Y/N�� add hq
    public static final String XML_SURVIVEGETMODE = "SurviveGetMode"; //�գ������������ȡ��ʽ����0	һ������ȡ��1	���ʽ��ȡ add hq

    public static final String XML_SUBFLAG = "SubFlag"; //������־
    public static final String XML_INSUSEQNO = "InsuSeqNo";
    /*
    //public static final String XML_GETDUTYKIND = "GetDutyKind"; //��ȡ��ʽ
       public static final String XML_SPEC = "Spec"; //�ر�Լ��
   */
    /**********************************LCPOL-������Ϣ�����������*********************************/

    /**********************************LCGet-��ȡ��Ϣ��������*********************************/
  //  public static final String XML_GETDUTY = "GetDuty";
    public static final String XML_GETINTV = "GetIntv"; //��ȡƵ��
    public static final String XML_GETYEAR = "GetYear"; //��ȡ��������
    public static final String XML_GETYEARFLAG = "GetYearflag"; //��ȡ�������ڱ�־
    public static final String XML_GETINSUYEAR = "GetInsuYear"; //�գ������������ȡ�ڼ�
    public static final String XML_GETRATE = "GetRate"; //��ȡ���� 

    public static final String XML_BASEPREM = "BasePrem"; //�������շ� 
    public static final String XML_INVESTPREM = "InvestPrem"; //���Ᵽ�շ� 
    public static final String XML_ADDPREM = "AddPrem"; //׷�ӱ��շ� 

    public static final String XML_GETBANKCODE = "GetBankCode"; //��ȡ���б���
    public static final String XML_GETBANKACCNO = "GetBankAccNo"; //��ȡ�����˻�
    public static final String XML_GETACCNAME = "GetAccName"; //��ȡ���л���
    public static final String XML_BONUSGETMODE = "BonusGetMode"; //������ȡ��ʽ

    public static final String XML_INVESTACCOUNTS = "InvestAccounts"; //Ͷ���˻��б�
    public static final String XML_INVESTACCOUNTCOUNT = "InvestAccountCount"; //Ͷ���˻���Ŀ
    public static final String XML_INVESTACCOUNT = "InvestAccount"; //Ͷ���˻��б�
    public static final String XML_ACCOUNTTYPE = "AccountType"; //Ͷ���˻����ͣ������ת��
    public static final String XML_ACCOUNTRATE = "AccountRate"; //Ͷ���˻��������
   /*
    public static final String XML_GETENDPERIOD = "GetEndPeriod"; // ��ȡ����
    public static final String XML_GETKIND = "GetKind"; //��ȡ��ʽ*/
    /**********************************LCGet-��ȡ��Ϣ�����������*********************************/


    /**********************************LCBNF-������Ϣ��������*********************************/
    public static final String XML_LCBNFS = "LCBnfs"; //�������б�
    public static final String XML_LCBNFCOUNT = "LCBnfCount"; //��������Ŀ
    public static final String XML_LCBNF = "LCBnf"; //
    public static final String XML_BNFTYPE = "BnfType"; //�������(���������/����������)
    public static final String XML_BNFNO = "BnfNo"; //���������
    //public static final String XML_INSUSEQNO = "InsuSeqNo"; //������������������� 
    public static final String XML_INSUREDNAME = "InsuredName"; //��������������������
    public static final String XML_RELATIONTOINSURED = "RelationToInsured"; //�������뱻���˹�ϵ
    public static final String XML_BNFIDEXPDATE = "BnfIDExpDate"; //������֤����Ч��
    public static final String XML_ADDRESSINFO = "AddressInfo";
    public static final String XML_BNFGRADE = "BnfGrade"; //�����˼���
    public static final String XML_BNFLOT = "BnfLot"; //����ݶ�
    /**********************************LCBNF-������Ϣ�����������*********************************/

    /**********************************LCISSUEPOL-�������Ϣ��������*********************************/
    public static final String XML_QUESTIONS = "Questions"; //�������Ϣ
    public static final String XML_QUESTIONCOUNT = "QuestionCount"; //�������
    public static final String XML_QUESTION = "Question"; //
    public static final String XML_QUESTIONLEVEL = "QuestionLevel"; //��������ؼ���
    public static final String XML_QUESTIONTYPE = "QuestionType"; //���������
    public static final String XML_QUESTIONCONTENT = "QuestionContent"; //���������
    /**********************************LCISSUEPOL-�������Ϣ�����������*********************************/
    
    public static final String MessageHeader = "<?xml version=\"1.0\" encoding=\"GBK\"?>"; // XML
	// ����ͷ
    public static final String ApplealPolicyCheckReturn = "AppealPolicyCheckReturn"; // ԤͶ�����ر��ĸ�Ԫ��

	public static final String PolicyAppealApplyReturn = "PolicyAppealApplyReturn"; // ȷ��Ͷ�����ر��ĸ�Ԫ��
	
}
