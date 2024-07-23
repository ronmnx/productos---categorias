<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Product y Categorias</title>
        </head>
        <body>
            <a href="products/new">New Product</a>
            <a href="categories/new">New Category</a>
            <h1>Products</h1>

            <table>
                <thead>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Category Count</th>
                    <th>Actions</th>
                </thead>
                <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.id}</td>
                            <td><a href="products/${product.id}">${product.name}</a></td>
                            <td>${product.description}</td>
                            <td>${product.price}</td>
                            <td>${product.categories.size()}</td>
                            <td>
                                <form action="products/${product.id}" method="post">
                                    <input type="hidden" name="_method" value="delete">
                                    <button type="submit">Delete</button>
                                </form>
                            </td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <br>
            <h1>Categories</h1>
            <table>
                <thead>
                    <th>Id</th>
                    <th>Category Name</th>
                    <th>Product Count</th>
                    <th>Actions</th>
                </thead>
                <tbody>
                    <c:forEach items="${categories}" var="category">
                        <tr>
                            <td>${category.id}</td>
                            <td><a href="categories/${category.id}">${category.name}</a></td>
                            <td>${category.products.size()}</td>
                            <td>
                                <form action="categories/${category.id}" method="post">
                                    <input type="hidden" name="_method" value="delete">
                                    <button type="submit">Delete</button>
                                </form>
                            </td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </body>
    </html>