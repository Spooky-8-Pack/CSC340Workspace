<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/storefront.css">
    <link rel="stylesheet" href="/css/navbar.css">
    <link rel="stylesheet" href="/css/login-panel.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">   
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${shop.shopName}</title>
</head>
<body>

    <nav class="navbar">
        <div class="nav-left">
            <a href="/index"><img src="/assets/UNCG_Spartan_Head.png" style="width: 75px; height: 75px" alt="UNC Greensboro spartan logo"></a>
            <div class="menu-dropdown">
                <button class="menu-button">
                    <img src="/assets/white-menu-icon.png" style="width: 36px; height: 36px" alt="Menu icon"/>
                    <span>Categories</span>
                </button>
                <div class="menu-content">
                    <a href="#">Tops</a>
                    <a href="#">Bottoms</a>
                    <a href="#">Dresses & Sets</a>
                    <a href="#">Shoes</a>
                    <a href="#">Accessories</a>
                    <a href="#">Headwear</a>
                </div>
            </div>
        </div>
    </nav>

    <section class="shop">

        
        <div class="shop-header">
            <img class="shop-image" src="/shop-images/${(shop.shopImagePath)!'No_Image_Available.jpg'}">
            <div class="shop-details">
                <div class="location">
                    <h3>Location</h2>
                    <p>${shop.location}</p>
                </div>
                <div class="Rating">
                    <h3>Rating</h3>
                    <p>Nothing yet</p>
                </div>
                <a href="/api/shops/updateForm/${shop.id}">Edit Shop</a>
            </div>
            <div class="seller-info">
                <h2>Seller</h2>
                <img id="seller-image" src="/seller-images/${(seller.sellerImagePath)!'No_Image_Available.jpg'}">
                <p>${seller.name}</p>
            </div>
        </div>

        <div class="shop-stuff">
             <div class="btnContainer">
                <button class="filterBtn" data-filter="about" onclick="event.preventDefault(); filterSelection('about')">About</button>
                <button class="filterBtn active" data-filter="products" onclick="event.preventDefault(); filterSelection('products')">Products</button>
                <button class="filterBtn" data-filter="reviews" onclick="event.preventDefault(); filterSelection('reviews')">Reviews</button>
                <button class="filterBtn" data-filter="statistics" onclick="event.preventDefault(); filterSelection('statistics')">Statistics</button>
            </div>

            <div class="filter-container">

                <div class="about">
                    <p>${shop.description}</p>
                </div>

                <div class="products">
                    <div class="product-card">
                        <img src="/products/${(seller.product.productImage)!'No_Image_Available.jpg'}" style="width: 200px; height: 200px">
                        <div class="prod-details">
                            <p>None</p>
                            <p>None</p>
                        </div>
                    </div>
                </div>

                <div class="reviews">
                    <div class="review-card">
                        <h3>${customer.name}</h3>
                        <p>Rating: ${customer.review.overallRating} </p>
                        <p>${customer.review.comment}</p>

                    </div>
                </div>

                <div class="statistics">
                    
                </div>
            </div>

        </div>


    </section>


    
<!-- Footer from https://mdbootstrap.com/snippets/standard/mdbootstrap/2885027?view=side -->
    <footer
            class="text-center text-lg-start text-white"
            style="background-color: #FFB71B"
            >
        <!-- Grid container -->
        <div class="container p-4 pb-0">
        <!-- Section: Links -->
        <section class="">
            <!--Grid row-->
            <div class="row">
            <!-- Grid column -->
            <div class="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3">
                <h6 class="text-uppercase mb-4 font-weight-bold">
                Company name
                </h6>
                <p>
                Here you can use rows and columns to organize your footer
                content. Lorem ipsum dolor sit amet, consectetur adipisicing
                elit.
                </p>
            </div>
            <!-- Grid column -->

            <hr class="w-100 clearfix d-md-none" />

            <!-- Grid column -->
            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mt-3">
                <h6 class="text-uppercase mb-4 font-weight-bold">Products</h6>
                <p>
                <a class="text-white">MDBootstrap</a>
                </p>
                <p>
                <a class="text-white">MDWordPress</a>
                </p>
                <p>
                <a class="text-white">BrandFlow</a>
                </p>
                <p>
                <a class="text-white">Bootstrap Angular</a>
                </p>
            </div>
            <!-- Grid column -->

            <hr class="w-100 clearfix d-md-none" />

            <!-- Grid column -->
            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mt-3">
                <h6 class="text-uppercase mb-4 font-weight-bold">
                Useful links
                </h6>
                <p>
                <a class="text-white">Your Account</a>
                </p>
                <p>
                <a class="text-white">Become an Affiliate</a>
                </p>
                <p>
                <a class="text-white">Shipping Rates</a>
                </p>
                <p>
                <a class="text-white">Help</a>
                </p>
            </div>

            <!-- Grid column -->
            <hr class="w-100 clearfix d-md-none" />

            <!-- Grid column -->
            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mt-3">
                <h6 class="text-uppercase mb-4 font-weight-bold">Contact</h6>
                <p><i class="fas fa-home mr-3"></i> New York, NY 10012, US</p>
                <p><i class="fas fa-envelope mr-3"></i> info@gmail.com</p>
                <p><i class="fas fa-phone mr-3"></i> + 01 234 567 88</p>
                <p><i class="fas fa-print mr-3"></i> + 01 234 567 89</p>
            </div>
            <!-- Grid column -->
            </div>
            <!--Grid row-->
        </section>
        <!-- Section: Links -->

        <hr class="my-3">

        <!-- Section: Copyright -->
        <section class="p-3 pt-0">
            <div class="row d-flex align-items-center">
            <!-- Grid column -->
            <div class="col-md-7 col-lg-8 text-center text-md-start">
                <!-- Copyright -->
                <div class="p-3">
                © 2020 Copyright:
                <a class="text-white" href="https://mdbootstrap.com/"
                    >MDBootstrap.com</a
                    >
                </div>
                <!-- Copyright -->
            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-5 col-lg-4 ml-lg-0 text-center text-md-end">
                <!-- Facebook -->
                <a
                class="btn btn-outline-light btn-floating m-1"
                class="text-white"
                role="button"
                ><i class="fab fa-facebook-f"></i
                ></a>

                <!-- Twitter -->
                <a
                class="btn btn-outline-light btn-floating m-1"
                class="text-white"
                role="button"
                ><i class="fab fa-twitter"></i
                ></a>

                <!-- Google -->
                <a
                class="btn btn-outline-light btn-floating m-1"
                class="text-white"
                role="button"
                ><i class="fab fa-google"></i
                ></a>

                <!-- Instagram -->
                <a
                class="btn btn-outline-light btn-floating m-1"
                class="text-white"
                role="button"
                ><i class="fab fa-instagram"></i
                ></a>
            </div>
            <!-- Grid column -->
            </div>
        </section>
        <!-- Section: Copyright -->
        </div>
        <!-- Grid container -->
    </footer> 

    <script src="/js/login-panel.js" defer></script>
    <script src="/js/seller-shop.js"></script>

    <script>
        document.addEventListener("DOMContentLoaded", function() {
            filterSelection("products");
        });
    </script>
    
    
</body>
</html>