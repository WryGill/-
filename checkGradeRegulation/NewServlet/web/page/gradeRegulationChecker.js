window.onload = function () {
    var studentIDRegExp = /^\d{10}$/;
    var studentNameRegExp = /^[\u4e00-\u9fa5]{2,4}$/;
    //正则表达式匹配输入格式
    document.getElementById("studentID").onblur = function () {
        var studentID = document.getElementById("studentID").value;
        if (!studentIDRegExp.test(studentID)){
            document.getElementById("studentIDError").innerText = "请填写正确的学号！";
        }else {
            document.getElementById("studentIDError").innerText = "√";
        }
    //    格式错误则输入框后显示异常信息，反之显示√
    }
    document.getElementById("studentName").onblur = function () {
        var studentName = document.getElementById("studentName").value;
        if (!studentNameRegExp.test(studentName)){
            document.getElementById("studentNameError").innerText = "请填写正确的姓名！";
        }else {
            document.getElementById("studentNameError").innerText = "√";
        }
    }

    document.getElementById("studentID").onfocus = function () {
        if (document.getElementById("studentIDError").innerText != "√"){
            document.getElementById("studentID").value = "";
        }
        document.getElementById("studentIDError").innerText = "";
    }
    document.getElementById("studentName").onfocus = function () {
        if (document.getElementById("studentNameError").innerText != "√") {
            document.getElementById("studentName").value = "";
        }
        document.getElementById("studentNameError").innerText = "";
    }
    document.getElementById("btn").onclick = function () {
        var studentID = document.getElementById("studentID").value;
        var studentName = document.getElementById("studentName").value;
        if (!studentNameRegExp.test(studentName) || !studentIDRegExp.test(studentID)){
            alert("考号或姓名不正确，请查证后查询！");
            window.location.href = "";
            //刷新当前页面
            return false;
        //    阻止get请求发送
        }
    }
}