function loadUserData(currentpage) {
    $.post(
        "http://localhost:8089/user/getUserList",//url
        {"currentpage":1,"userid":3}, function (data){
            doload(data)
        });
}

//加载函数
$(function () {
    loadUserData(1);
});

//删
function del(id) {
    //id:要删除用户的id
    //userid：当前用户id，预留字段，做权限用
    if(window.confirm("确定删除？")){
        $.post(
            "/user/deleteUserById",
            {"userid":3,"id":id},
            function (data) {
                if (data == "false") {
                    alert("删除失败！");
                } else {
                    alert("删除成功！");
                    window.location.reload();
                }
            }
        );
    }
}

function lock(id,status) {
    //id:要删除用户的id
    //userid：当前用户id，预留字段，做权限用
    $.post(
        "/user/updateUserById",
        {"userid":3,"id":id,"status":status},
        function (data) {
            console.log("--getUserList-- "+data)
            if (data == "false") {
                alert("操作失败！");
                return false;
            }else {
                return true;
            }
        }
    );
}

//查
function searchBtn() {
    var search = $("#search").val();
    $.post(
        "http://localhost:8089/user/getUserList",//url
        {"currentpage":1,"userid":3,"search":search}, function (data){
            doload(data);
        });
}

//改
function modify(userid) {
    window.location.href = "./modify.html?userid=" + userid;
}

//将数据遍历到网页上
function doload(data) {
    var json = JSON.parse(data);
    var item = json["items"];
    var length = item.length;

    var userlist = "";
    for (var i = 0; i < length; i++) {
        var id = item[i]["id"];
        var username = item[i]["username"];
        var name = item[i]["name"];
        var gender = item[i]["gender"];
        var phone = item[i]["phone"];
        var email = item[i]["email"];
        var address = item[i]["address"];
        var cardId = item[i]["cardId"];
        var status = item[i]["status"];
        var createTime = renderTime(item[i]["createTime"]);
        var updateTime = renderTime(item[i]["updateTime"]);

        var html = "<tr>\n" +
            "<td> " +
            "  <div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='"+ id +"'>" +
            "    <i class=\"layui-icon\">&#xe605;</i></div>" +
            "</td>\n" +
            "<td>" + id + "</td>\n" +
            "<td>" + username + "</td>\n" +
            "<td>" + name + "</td>\n" +
            "<td>" + gender + "</td>\n" +
            "<td>" + phone + "</td>\n" +
            "<td>" + email + "</td>\n" +
            "<td>" + address + "</td>\n" +
            "<td>" + cardId + "</td>\n" +
            "<td>" + createTime + "</td>\n" +
            "<td>" + updateTime + "</td>\n";
        if (status==1){
            // item[i]["status"] = 0;
            var statushtml =
                "<td class=\"td-status\">\n" +
                "  <span class=\"layui-btn layui-btn-normal layui-btn-mini layui-btn-disabled\">已停用</span>\n" +
                "</td>\n" +
                "<td class=\"td-manage\">\n" +
                "  <a onclick=\"member_stop(this," + id + ","+status+")\" href=\"javascript:;\"  title=\"启用\">\n" +
                "    <i class=\"layui-icon\">&#xe62f;</i>\n" +
                "  </a>\n" +
                "  <a title=\"编辑\"  onclick=\"x_admin_show('编辑','member-edit.html',600,400)\" href=\"javascript:;\">\n" +
                "    <i class=\"layui-icon\">&#xe642;</i>\n" +
                "  </a>\n" +
                "  <a title=\"删除\" onclick=\"del(" + id + ")\" href=\"javascript:;\">\n" +
                "    <i class=\"layui-icon\">&#xe640;</i>\n" +
                "  </a>\n" +
                "</td>" +
                "    </tr>"
        } else {
            // item[i]["status"] = 1;
            var statushtml =
                "<td class=\"td-status\">\n" +
                "  <span class=\"layui-btn layui-btn-normal layui-btn-mini\">已启用</span>\n" +
                "</td>\n" +
                "<td class=\"td-manage\">\n" +
                "  <a onclick=\"member_stop(this," + id + ","+status+")\" href=\"javascript:;\"  title=\"停用\">\n" +
                "    <i class=\"layui-icon\">&#xe601;</i>\n" +
                "  </a>\n" +
                "  <a title=\"编辑\"  onclick=\"x_admin_show('编辑','member-edit.html',600,400)\" href=\"javascript:;\">\n" +
                "    <i class=\"layui-icon\">&#xe642;</i>\n" +
                "  </a>\n" +
                "  <a title=\"删除\" onclick=\"del(" + id + ")\" href=\"javascript:;\">\n" +
                "    <i class=\"layui-icon\">&#xe640;</i>\n" +
                "  </a>\n" +
                "</td>" +
                "    </tr>"
        }
        html += statushtml;
        userlist += html;
    }
    //用户数据列表
    $("#userlist").empty();
    $("#userlist").html(userlist);

    //当前页
    $("#currentPage").empty();
    $("#currentPage").html(json["currPage"]);
    //总数据
    $("#total").empty();
    $("#total").html("总数据量"+json["total"]);

    //翻页
    $("#pagerutil").empty();
    var pager = " <a href=\"#\" onclick=\"loadSingerData(1)\" style=\"color:#000\">首页</a>\n" +
        "            <a href=\"#\" onclick=\"loadSingerData(" + (json["currPage"] - 1) + ")\" style=\"color:#000\">上页</a>\n" +
        "            <a href=\"#\" style=\"color:#000\">" + json["currPage"] + "/" + json["totalPage"] + "</a>\n" +
        "            <a href=\"#\" onclick=\"loadSingerData(" + (json["currPage"] + 1) + ")\" style=\"color:#000\">下页</a>\n" +
        "            <a href=\"#\" onclick=\"loadSingerData(" + (json["totalPage"]) + ")\" style=\"color:#000\">尾页</a>";
    $("#pagerutil").append(pager);
}

//Json格式的时间函数
function renderTime(date){
    var datestring = date.toString();
    var da = new Date(parseInt(datestring.replace("/Date(","").replace(")/","").split("+")[0]));
    return da.getFullYear()+"-"+ (da.getMonth()+1)+"-" +da.getDate()+" " +da.getHours()+":"+da.getSeconds()+":"+da.getMinutes();
};