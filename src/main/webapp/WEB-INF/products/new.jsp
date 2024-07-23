<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=
    , initial-scale=1.0">
                <title>New Product</title>
            </head>
            <body>
                <h1>New Product</h1>
                <form:form action="new" modelAttribute="product">
                    <p>
                        <form:label path="name" for="name">Name: </form:label>
                        <form:input type="text" path="name" id="name" />
                    </p>
                    <p>
                        <form:label path="description" for="description">Description: </form:label>
                        <form:textarea path="description" id="description"></form:textarea>
                    </p>
                    <p>
                        <form:label path="price" for="price">Price: </form:label>
                        <form:input type="text" path="price" id="price" />
                    </p>
                    <button type="submit">Save</button>
                </form:form>
            </body>
        </html>