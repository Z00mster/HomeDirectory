<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Home Directory</title>
        <link rel="stylesheet" href="<c:url value="/resources/css/main.css" />" />
        <script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        <script src="<c:url value="/resources/javascript/main.js" />"></script>
    </head>
    <body>
        <header>
            <h1>${parentName}</h1>
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
            <a href="${pageContext.request.contextPath}/goback">Go back</a>
        </header>

        <main>
        	<form id="form" action="${pageContext.request.contextPath}/goto" method="post">
	        	<c:forEach items="${folder.content}" var="content">
					<div class="content-block">
						<c:choose>
							<c:when test="${not content.isDirectory}">
								<img src="<c:url value="/resources/images/file.png" />" width=50 height=50 />
							</c:when>
							<c:otherwise>
									<img onClick='submitForm(this)' class="folder-image" src="<c:url value="/resources/images/folder.jpg" />" width=50 height=50 />
									<input type="submit" name="${content.fullName}" value="${content.fullName}" />
							</c:otherwise>
						</c:choose>
						<p>${content.name}</p>
					</div>
				</c:forEach>
			</form>
        </main>

        <footer>

        </footer>
    </body>
</html>
