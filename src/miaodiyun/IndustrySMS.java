package miaodiyun;

import java.net.URLEncoder;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	//private static String to = "15084783320";
	private static String smsContent = "尊敬的用户，您的验证码为{1}";
	private static String templateid = "277970299";
	/**
	 * 验证码通知短信
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
       // 提交请求
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
	}
}

