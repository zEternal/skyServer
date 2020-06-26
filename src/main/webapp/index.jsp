<%--
  Created by IntelliJ IDEA.
  User: eternal
  Date: 2020/3/17
  Time: 下午3:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
      <script src="js/jquery.min.js"></script>
      <script>

          $(function(){
              $("#btn").click(function () {
                  alert("hello");
                  $.ajax({
                      url: "user/findAll",
                      type: 'POST',
                      contentType: "application/json;charset=UTF-8",
                      data: '{"username":"haha","password":"12344","age":23}',
                      dataType: "json",
                      success: function (data) {
                          alert(data.toString());
                          for (var i=0;i<data.length;i++){
                              alert(data[i].id);
                              alert(data[i].username);
                          }
                      }
                  });
              });

              $("#sub").click(function () {
                  alert("hello");
                  $.ajax({
                      url: "user/saveUser",
                      type: 'POST',
                      contentType: "application/json;charset=UTF-8",
                      data: '{"username":"haha","password":"12344"}',
                      dataType: "json",
                      success: function (data) {
                          alert(data);
                      }
                  });
              });
          });
      </script>
  </head>
  <body>
      <a href="orders.html"><button id="order">order</button></a>
      <a href="view.html"><button id="car">car</button></a>
      <a href="maps.html"><button id="map">map</button></a>

      <button id="btn">fasong</button>
      <a href="user/findAll">ceshi</a>
      <br><br><br><br><br>
      <form id="fo">
          username:<input type="text" name="username"><br>
          password:<input type="text" name="password"><br>
          <button id="sub">okkkk</button>
      </form>
  </body>
</html>
