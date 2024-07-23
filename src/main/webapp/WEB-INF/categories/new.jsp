<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>New Category</title>
            </head>
            <body>
                <h1>New Category</h1>
                <form:form action="new" modelAttribute="category">
                    <p>
                        <form:label path="name" for="name">Name: </form:label>
                        <form:input type="text" path="name" id="name" />
                    </p>
                    <button type="submit">Save</button>
                </form:form>
            </body>
        </html>