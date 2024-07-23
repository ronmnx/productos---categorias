<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>${category.name}</title>
            </head>
            <body>
                <h1 style="text-align: center;">${category.name}</h1>
                <div class="container" style="display: flex;justify-content: space-around;">
                    <div class="left">
                        <h2>Products</h2>
                        <c:forEach items="${category.products}" var="product">
                            <ul>
                                <li>${product.name}</li>
                            </ul>
                        </c:forEach>
                    </div>
                    <div class="rigth">

                        <form action="${category.id}" method="post">
                            <p>
                                <label for="productId">Add Product: </label>
                                <select name="productId" id="productId">
                                    <c:forEach items="${products}" var="p">
                                        <option value="${p.id}">${p.name}</option>
                                    </c:forEach>
                                </select>
                            </p>
                            <button type="submit">Add</button>
                        </form>
                    </div>
                </div>


            </body>
        </html>