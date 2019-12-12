function loadSingerData(currentpage) {
    $.post(
        "http://localhost:8089/user/getUserList",//url
        {"currentpage":1,"userid":3}, function (data){
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
                var createTime = renderTime(item[i]["createTime"]);
                var updateTime = renderTime(item[i]["updateTime"]);

                var html = "<tr>\n" +
                    "<td>\n" +
                    "        <div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='2'><i class=\"layui-icon\">&#xe605;</i></div>\n" +
                    "      </td>\n" +
                    "      <td>" + id + "</td>\n" +
                    "      <td>" + username + "</td>\n" +
                    "      <td>" + name + "</td>\n" +
                    "      <td>" + gender + "</td>\n" +
                    "      <td>" + phone + "</td>\n" +
                    "      <td>" + email + "</td>\n" +
                    "      <td>" + address + "</td>\n" +
                    "      <td>" + cardId + "</td>\n" +
                    "      <td>" + createTime + "</td>\n" +
                    "      <td>" + updateTime + "</td>\n" +
                    "      <td class=\"td-status\">\n" +
                    "        <span class=\"layui-btn layui-btn-normal layui-btn-mini\">已启用</span>\n" +
                    "      </td>\n" +
                    "      <td class=\"td-manage\">\n" +
                    "        <a onclick=\"member_stop(this,'10001')\" href=\"javascript:;\"  title=\"启用\">\n" +
                    "          <i class=\"layui-icon\">&#xe601;</i>\n" +
                    "        </a>\n" +
                    "        <a title=\"编辑\"  onclick=\"x_admin_show('编辑','member-edit.html',600,400)\" href=\"javascript:;\">\n" +
                    "          <i class=\"layui-icon\">&#xe642;</i>\n" +
                    "        </a>\n" +
                    "        <a title=\"删除\" onclick=\"del(" + id + ")\" href=\"javascript:;\">\n" +
                    "          <i class=\"layui-icon\">&#xe640;</i>\n" +
                    "        </a>\n" +
                    "      </td>" +
                    "    </tr>"
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
        });
}

//加载函数
$(function () {
    loadSingerData(1);
});

//Json格式的时间函数
function renderTime(date){
    var datestring = date.toString();
    var da = new Date(parseInt(datestring.replace("/Date(","").replace(")/","").split("+")[0]));
    return da.getFullYear()+"-"+ (da.getMonth()+1)+"-" +da.getDate()+" " +da.getHours()+":"+da.getSeconds()+":"+da.getMinutes();
};

//删
function del(id) {
    //id:要删除用户的id
    //userid：当前用户id，预留字段，做权限用
    if(window.confirm("确定删除？")){
        $.post(
            "/user/deleteUserById",
            {"userid":3,"id":id},
            function (data) {
                console.log("--getUserList-- "+data)
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

//改
function modify(userid) {
    window.location.href = "./modify.html?userid=" + userid;
}

//查
// function querySingerNames() {
//     var querySingerName = document.getElementById("querySingerName").value;
//     $.post(
//         "http://127.0.0.1:8080/aquerybysingername.do?singerName=" + querySingerName,
//         {},
//         function (data) {
//
//             var ul_item = $("#singerList");
//
//             ul_item.empty();
//             for (var i = 0; i < data.data.length; i++) {
//                 var li_item = "<tr>" +
//                     "<td tabindex=\"0\" class=\"sorting_1\">" + data.data[i].singerName + "</td>" +
//                     " <td>" + data.data[i].sex + "</td>" +
//                     // " <td><textarea style=\"width: 500px\">"+data.data.data[i].albumMessage+"</textarea></td> " +
//                     " <td>" + data.data[i].singerNation + "</td> " +
//                     " <td>" + data.data[i].singerBirthday + "</td> " +
//                     " <td>" + data.data[i].fansNum + "</td> " +
//                     "<td style=\"width:200px\">" +
//                     "<a href=\"javascript:void(0)\" onclick= del(" + data.data[i].singerId + ")>删除</a>&nbsp;&nbsp;|&nbsp;&nbsp;" +
//                     "<a href=\"javascript:void(0)\" onclick= modify(" + data.data[i].singerId + ")>编辑</a>&nbsp;&nbsp;" +
//                     "</td>" +
//                     //"<td><a href=\"modify.html\"><button onclick= modify(data.data.data[i].albumId)>修改</button></a><button>删除</button></td>"+
//                     "</tr>";
//                 ul_item.append(li_item);
//
//                 $("#pagerutil").empty();
//             };
//         }
//     );
// }