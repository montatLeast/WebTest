package miaodiyun;

import java.net.URLEncoder;

/**
 * ��֤��֪ͨ���Žӿ�
 * 
 * @ClassName: IndustrySMS
 * @Description: ��֤��֪ͨ���Žӿ�
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	//private static String to = "15084783320";
	private static String smsContent = "�𾴵��û���������֤��Ϊ{1}";
	private static String templateid = "277970299";
	/**
	 * ��֤��֪ͨ����
	 */
	public static void execute(String to,String num)
	{
		/*
		String tmpSmsContent = null;
	    try{
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      
	    }*/
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + to + "&templateid=" + templateid 
	    		+ "&param=" + num 
		        + HttpUtil.createCommonParam();
	    /*
	    String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
	        + HttpUtil.createCommonParam();
	        */
       // �ύ����
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
	}
}

