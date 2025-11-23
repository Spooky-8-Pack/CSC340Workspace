<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/login-panel.css">
    <link rel="stylesheet" href="/css/navbar.css">
    <link rel="stylesheet" href="/css/sell-now.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">   
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
    <title>Sell Now</title>
</head>
<body>
    
    <nav class="navbar">
        <div class="nav-left">
            <a href="index.html"><img src="./assets/UNCG_Spartan_Head.png" style="width: 75px; height: 75px" alt="UNC Greensboro spartan logo"></a>
            <div class="menu-dropdown">
                <button class="menu-button">
                    <img src="./assets/white-menu-icon.png" style="width: 36px; height: 36px" alt="Menu icon"/>
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
        
        <div class="nav-center">
            <!-- Search bar from https://codepen.io/huange/pen/bGqMqM -->
            <div class="search-container">
                <form action="#">
                    <input type="text" class="search-bar" placeholder="Search..">
                    <button class="search-button" type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
        </div>

        <div class="nav-right">
            <div class="icons">
                <button id="profile"><i class="fa-solid fa-user"></i></button>
                <button class="heart"><i class="fa-solid fa-heart"></i></button>
                <button class="cart"><i class="fa-solid fa-cart-shopping"></i></button>
            </div>
            
        </div>
        
    </nav>

    <div class="login-panel" id="login-panel">
        <h2>Hello Guest,</h2>
        <div class="panel-buttons">
            <div class="log-in-out">
                <a href="./sign-in.html" class="sign-in">Sign in</a>
                <a href="./sign-up.html" class="sign-up">Sign up</a>
            </div>
            <a href="./sell-now.html" class="sell-now">Sell now</a>
        </div>
    </div>   

    <div class="signup">
        <div class="signup-container">
            <div class="header">
                <h1>Sign up to sell today!</h1>
                <span>Already have an account? <a href="./sign-in.html">Sign In</a></span>
            </div>
            <div class="form">
                <form action="/api/sellers" method="post" enctype="multipart/form-data">
                    <h3>Seller Info</h3>
                    <input type="text" name="name" id="name" placeholder="Name">
                    <input type="email" name="email" id="email" placeholder="Email"/>
                    <input type="password" name="password" id="password" placeholder="Password"/>
                    <input type="file" name="sellerImage" id="sellerImage" placeholder="Upload your picture!"accept="image/png, image/jpeg">
                    <small>Add an  image of yourself!</small>  

                    <h3>Shop Info</h3>
                    <input type="text" name="storeName" id="storeName" placeholder="Store name">
                    <input type="text" name="description" id="description" placeholder="Shop description">
                    <input type="text" name="location" id="location" placeholder="Location">
                    <input type="file" name="shopImage" id="shopImage" placeholder="Upload storefront image!"accept="image/png, image/jpeg">
                    <small>Add an  image for your shop storefront!</small>  
                    
                    <button type="submit" class="btn btn-primary">Save</button>
                    <a href="/api/sellers" class="btn btn-outline-danger">Cancel</a>
                </form>
            </div>
                </form>
            </div>
        </div>
    </div>

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

    <script src="./js/login-panel.js"></script>
</body>
</html>