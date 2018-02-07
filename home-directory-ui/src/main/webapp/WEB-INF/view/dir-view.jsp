<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>The Crossroads</title>
       <%--  <link rel="stylesheet" href="<c:url value="/resources/css/main.css" />" /> --%>
    </head>
    <body>
        <header>
            <h1>${parentName}</h1>
        </header>

        <main>
			<c:forEach items="${files}" var="file">
				<p>
					<img src="<c:url value="/images/${file.imageSource}" />" width=50 height=50 />
					<span>${file.name}</span>
				</p>
			</c:forEach>
        </main>

        <footer>

        </footer>
    </body>
</html>
