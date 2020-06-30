<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #left {
            width: 10%;
            height: 90%;
            border: 1px solid lightsalmon;
            float: left;

        }

        #right {
            width: 80%;
            height: 90%;
            border: 1px solid sienna;
            float: left;
            margin-left: 0.3%;
        }

        li {
            list-style: none;
        }
    </style>
    <script>
        window.onload = function (ev) {
            // $.ajax({
            //     url: "/menu",
            //     type: "get",
            //     data: "",
            //     dataType: "json",
            //     success: function (data) {
            //         var html = '';
            //         for (var i = 0; i < data.length; i++) {
            //             var menu_1 = data[i];
            //             if (menu_1.type == 1) {
            //                 html += data[i].name;
            //                 html += '<ul>';
            //                 for (var j = 0; j < data.length; j++) {
            //                     var menu_2 = data[j];
            //                     if (menu_1.id == menu_2.pId) {
            //                         html += '<li><a href="../dept/dept.jsp">'+menu_2.name+'</a></li>';
            //                     }
            //                 }
            //                 html += '</ul>'
            //             }
            //         }
            //         $("#left").append(html);
            //     }
            // });
            $.ajax({
                url: "/menu",
                type: "get",
                data: "",
                dataType: "json",
                success: function (data) {
                    var parent=data.parent;
                    var son=data.son;
                    var html = '';
                    for (var i = 0; i <parent.length; i++) {
                        console.log(parent[i].name);
                        html+=parent[i].name;
                        html+='<ul>';
                        for (var j = 0; j < son.length; j++) {
                            if (parent[i].id==son[j].pId){
                           html+='<li><a href="'+son[j].url+'">'+son[j].name+'</a></li>';
                            }
                        }
                        html+='</ul>';
                    }
                    $("#left").append(html);
                }
            });
        }
    </script>
</head>
<body>
<div id="left">
    <%--<h3>系统管理</h3>--%>
    <%--<ul>--%>
    <%--<li><a href="../dept/dept.jsp">部门管理</a></li>--%>
    <%--<li><a href="../user/user.jsp">用户管理</a></li>--%>
    <%--</ul>--%>
    <%--<h3>权限管理</h3>--%>
    <%--<ul>--%>
    <%--<li>角色管理</li>--%>
    <%--<li>管理员管理</li>--%>
    <%--</ul>--%>
</div>
</body>
</html>
