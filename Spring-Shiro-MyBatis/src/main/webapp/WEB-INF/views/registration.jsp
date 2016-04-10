<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="银澎信息技术有限公司">
<title>勤吧任务录入</title>
<link id="bs-css" href="resource/css/registration.css" rel="stylesheet">
</head>
<body style="background-color: #F2F2F2;">
	
	<div class="reg-title wrap">
		<img src="${imagesCtxPath}/reg-title.png" width="120" height="30"
			alt="" /> <span>
			<p>我已经注册，现在就</p> <a href="${ctx}/news/index.htm">登陆</a>
		</span>
	</div>
	
	<div class="reg-bd wrap">
		<div class="reg-list">
			<div align="center">
				<c:if test="${requestScope.tips=='success'}">
					亲爱的用户，恭喜您注册成功，欢迎您加入勤吧，更多任务，更多奖励，从勤吧开始。<span id="show"></span>
				</c:if>
				<c:if test="${requestScope.tips=='activated'}">
					该用户已经激活过了，无需再次激活！<span id="show"></span>
				</c:if>
				<c:if test="${requestScope.tips=='timeout'}">
					激活超时！<span id="show"></span>
				</c:if>
				<c:if test="${requestScope.tips=='error'}">
					未找到该用户,先去注册吧！
				</c:if>
			</div>
			<form id="registForm" action="${ctx}/staff/registEntryClert.htm"
				method="post">
				<table border="1">
					<tr>
						<td class="tar"><sup>*</sup>电子邮箱：</td>
						<td><input type="text" class="icon-email" maxlength="30" name="email"
							id="email" autocomplete="off"><span id="emailMsg"></span></td>
						<!--  <td class="tal">邮箱为唯一注册验证的渠道，包括注册工号， 找回密码，请填写常用的电子邮箱。</td>-->
					</tr>

					<!-- <tr>
						<td class="tar"><sup>*</sup>真实姓名：</td>
						<td><input type="text" class="icon-name" name="realName"
							id="realName"></td>
						<td class="tal">需真实姓名以便收款</td>
					</tr>
					<tr>
						<td class="tar"><sup>*</sup>常用QQ：</td>
						<td><input type="text" class="icon-qq" name="qq" id="qq"></td>
						<td class="tal">必填</td>
					</tr>
					<tr>
						<td class="tar">手机号码：</td>
						<td><input type="text" class="icon-phone" name="contactPhone"
							id="contactPhone"></td>
						<td class="tal">选填</td>
					</tr> -->
					
					<tr>
						<td class="tar"><sup>*</sup>请设置密码：</td>
						<td><input type="password" class="icon-lock" name="password"
							id="res_password"><span id="res_passwordMsg"></span></td>
						<!-- <td class="tal">6位字母、数字、两者组合</td> -->
					</tr>
					<tr>
						<td class="tar"><sup>*</sup>请确认密码：</td>
						<td><input type="password" class="icon-lock"
							name="confirmPassword" id="confirmPassword"><span id="confirmPasswordMsg"></span></td>
						<!-- <td class="tal">需要与上面密码一致</td> -->
					</tr>
					<tr>
						<td></td>
						<td><input type="checkbox" checked="checked" id="agree">我已阅读并同意<a
							href="#" id="pro_register">银澎用户注册协议</a></td>
						<td></td>
					</tr>
					<tr>
						<td class="tar"></td>
						<td><button type="button" class="reg-bts" id="registSubmit"></button></td>
						<td></td>
					</tr>


				</table>
			</form>
		</div>
		<div class="reg-ad">
			<div class="qq-notice">
				<h5>平台录入官方QQ群</h5>
				<ul>
					<li>在线打字兼职群1 -335313546</li>
					<li>在线打字兼职群2 -206764698</li>
					<li>在线打字兼职群3 -196767472</li>
					<li>在线打字兼职群4 -372607042</li>
				</ul>

			</div>
			<div class="pic-2">
				<img src="${imagesCtxPath}/pic2.jpg" width="127" height="127" alt="" />
				<p>扫一扫，更多活动任务，请关注官方微信</p>
			</div>
		</div>

	</div>
	<div class="copyright wrap">
		<p>上海银澎技术技术有限公司版权所有</p>
	</div>
	
	<div class="pro pos-f" id="pro_div">
		<div class="pro-title">
			<h5>银澎平台服务协议</h5>
			<span class="close" id="proClose">×</span>
		</div>
		<div class="pro-bts">
			<button id="agree_pro_button"></button>
		</div>
	</div>
	
	<div class="pos-f back-email" id="email_div">
		<div class="back-email-t">
			<span class="close" id="emailClose">×</span> <img
				src="${imagesCtxPath}/back-email.gif" width="290" height="55" alt="" />
		</div>
		<div class="back-email-c">
			<span>
				<p>您好，已发送激活邮件到您的注册邮箱，请在30分钟内激活</p> <a id="mailUrl" href="http://mail.qq.com/cgi-bin/frame_html?">http://mail.qq.com/cgi-bin/frame_html?</a>
			</span>
			<a id="mailButton" href="#"><button></button></a>
		</div>
		<div class="back-email-b">
			<dt>收不到邮件</dt>
			<dd>
				<b>●</b>有可能为误认为是垃圾邮件，到垃圾邮件文件夹看看
			</dd>
			<dd>
				<b>●</b><a id="send_link" href="#">点击这里</a>发验证邮件到你的邮箱
			</dd>
		</div>
	</div>
</body>
</html>