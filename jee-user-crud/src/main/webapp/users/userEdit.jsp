<%--
  Created by IntelliJ IDEA.
  User: rafa
  Date: 01.01.2023
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>SB Admin 2</title>
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

  <!-- Sidebar -->
  <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="../users/list.jsp">
      <div class="sidebar-brand-icon rotate-n-15">
        <i class="fas fa-laugh-wink"></i>
      </div>
      <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
      <a class="nav-link" href="../users/list.jsp">
        <i class="fas fa-fw fa-tachometer-alt"></i>
        <span>Dashboard</span></a>
    </li>


    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
      <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>



  </ul>
  <!-- End of Sidebar -->

  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column">

    <!-- Main Content -->
    <div id="content">
      <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
      </nav>

      <!-- End of Topbar -->

      <!-- Begin Page Content -->
      <div class="container-fluid">

        <!-- Page Heading -->
        <div class="d-sm-flex align-items-center justify-content-between mb-4">
          <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
          <a href="http://localhost:8080/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                  class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika</a>
        </div>
        <div class="card shadow mb-5" style="border-radius: 25px">
          <div style="background: whitesmoke">
            <p style="color:royalblue;padding-left: 10px;padding-top: 10px"><b>Edycja użytkownika</b></p>
            <hr class="sidebar-divider my-0">
            <div style="background: white; padding-top: 10px; padding-left: 10px; padding-bottom: 10px">
              <form method="post">
              <label for="username">Nazwa</label><br>
              <input type="text" id="username" name="username" value="${user.userName}"><br>
              <label for="email">Email</label><br>
              <input type="email" id="email" name="email" value="${user.email}"><br>
              <label for="password">Hasło</label><br>
              <input type="text" id="password" name="password" placeholder="Hasło użytkownika"><br><br>
              <input class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" type="submit" value="Zapisz">
                </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <%@ include file="/theme/footer.jsp" %>
</body>
</html>