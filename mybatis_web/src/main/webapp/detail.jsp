<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2018/10/31
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>慕课网用户管理中心</title>
    <link rel="stylesheet" href="lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="lib/2.2.4/jquery-1.12.4.min.js"></script>
    <script src="lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>慕课网后台管理系统<small>用户数据管理中心</small></h1></div>
    </div>

    <div class="row">
        <div class="jumbotron">
            <h1>MyBatis基础入门课程!</h1>
            <p>通过一个项目来完成基础部分的学习</p>
            <p><a class="btn btn-primary btn-lg" href="#" role="button">查看更多，请上慕课网</a></p>
        </div>
    </div>
    <c:set var="user" value="${user}"></c:set>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${user.username}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">*******</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="nickname" class="col-sm-2 control-label">用户昵称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="nickname" placeholder="${user.nickname}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="age" class="col-sm-2 control-label">年龄</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="age" placeholder="${user.age}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="gender" class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="gender" placeholder="${user.gender}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-2 control-label">电话</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="phone" placeholder="${user.phone}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="emial" class="col-sm-2 control-label">邮箱</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="emial" placeholder="${user.emial}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">创建时间</label>
                    <div class="col-sm-10">
                        <p class="form-control-static"><fmt:formatDate value="${user.createTime}" pattern="yyyy-mm-dd"></fmt:formatDate></p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">修改时间</label>
                    <div class="col-sm-10">
                        <p class="form-control-static"><fmt:formatDate value="${user.updateTime}" pattern="yyyy-mm-dd"></fmt:formatDate></p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">登录时间</label>
                    <div class="col-sm-10">
                        <p class="form-control-static"><fmt:formatDate value="${user.lastLogin}" pattern="yyyy-mm-dd"></fmt:formatDate></p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">用户状态</label>
                    <div class="col-sm-10">
                        <c:if test="${user.userStatus == 0}">
                            <p class="form-control-static">正常</p>
                        </c:if>
                        <c:if test="${user.userStatus == 1}">
                            <p class="form-control-static">锁定</p>
                        </c:if>
                        <c:if test="${user.userStatus == 2}">
                            <p class="form-control-static">删除</p>
                        </c:if>
                    </div>
                </div>
                <div class="form-group">
                    <label for="remark" class="col-sm-2 control-label">备注</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="remark" placeholder="${user.remark}">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
