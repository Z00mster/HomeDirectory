<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>The Crossroads</title>
    </head>
    <body>
        <header>
            <h1>Welcome to login</h1>
        </header>

        <main>
			<form action="${pageContext.request.contextPath}/login" method="post">
				<input type="password" name="password" />
				<input type="submit" value="Log In" />
			</form>
        </main>

        <footer>

        </footer>
    </body>
</html>
