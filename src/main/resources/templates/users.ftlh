
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1>Admin page</h1>
<h2>Users:</h2>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Email</td>
        <td>Role</td>
        <td>Sate</td>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.email}</td>
            <td>${user.role.name()}</td>
            <td>${user.state.name()}</td>

        </tr>
    </#list>



</table>






</body>
</html>