<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>

    <title>Ecommerce Product Website - Easy Tutorials</title>
    <link href="/css/customer/book.css" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

</head>

<body>
    <nav class="navbar">
		<div class="nav">
			<a href="backToHome"> <img src="/images/customer/blogo-c.png"
				class="brand-logo" alt="">
			</a>
		</div>
	</nav>

    <div class="hero">
        <div class="row">
            <div class="col">

                <div class="slider">
                   
                    <div class="preview">
                        <img src="images/admin/${book.bookId}.jpg" id="imagebox" alt="">
                    </div>
                </div>

            </div>
            <div class="col">

                <div class="content">
                    <p class="brand">Publisher : ${book.bookPublisher}</p>
                    <h2>${book.bookName}</h2>
                    <p class="price">Author : ${book.bookAuthor}</p>
                    <p>${book.bookGenre}</p>
                    <p>Rs. 310</p>
					<a href="addtocart?bookId=${book.bookId}">                
                    <button type="button">
                        <i class="fa fa-shopping-cart"></i>
                        Add to cart</button>
                    </a>
                    
                </div>

            </div>
        </div>

        <div class="bootomNavBar">
            <p align="center">
                <b>&#169; Copyright OnlineBookStore Virtusa <b>
            </p>
        </div>



</body>

</html>