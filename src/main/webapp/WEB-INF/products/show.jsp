<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <!DOCTYPE html>
        <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>${product.name}</title>
            </head>
            <body>
                <h1 style="text-align: center;">${product.name}</h1>
                <div class="container" style="display: flex;justify-content: space-around;">
                    <div class="left">
                        <h2>Categories</h2>
                        <c:forEach items="${productCategories}" var="category">
                            <ul>
                                <li>${category.name}</li>
                            </ul>
                        </c:forEach>
                    </div>
                    <div class="rigth">

                        <form action="${product.id}" method="post">
                            <p>
                                <label for="category">Add Category: </label>

                                <select name="categoryId" id="category">
                                    <c:forEach items="${categories}" var="c">
                                        <option value="${c.id}">${c.name}</option>
                                    </c:forEach>
                                </select>
                            </p>
                            <button type="submit">Add</button>
                        </form>
                    </div>
                </div>

            </body>
        </html>