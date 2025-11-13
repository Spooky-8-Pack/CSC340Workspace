<!-- Customer Profile -->
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width", initial-scale="1" />
        <style>
        body {
      font-family: Arial, sans-serif;
      margin: 0; padding: 0;
      background: #f9f9f9;
    }
    header {
      background: #880000;
      padding: 1em;
      color: white;
      text-align: center;
    }
    nav {
      background: #333;
      display: flex;
      justify-content: center;
    }
    nav a {
      color: white;
      padding: 1em;
      text-decoration: none;
      display: block;
    }
    nav a:hover {
      background-color: #575757;
    }
    main {
      max-width: 700px;
      margin: 2em auto;
      background: white;
      padding: 1.5em;
      border-radius: 8px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    }
    h2 {
      margin-top: 0;
    }
    .customer-details {
      line-height: 1.5;
      color: #333;
    }
    </style>
    </head>
    
    <body>
        <header>
          <h1>Your Profile</h1>
        </header>
        <nav>
          <a href="/home">Home</a>
          <a href="/customers/${customer.customerId}/update">Update Your Profile</a> 
          <a href="/customers/{id}/delete">Delete Your Profile</a> 
          <a href="">View Your Cart</a> <!-- To Do: Add Cart View -->
          </nav>
        <main id="content">
         <h2>${customer.name}</h2>
              <div class="customer-details">
                <p><strong>Address:</strong> ${customer.address}</p>
                <p><strong>Email:</strong> ${customer.email} years</p>
              </div>     
        </main>
    </body>
</html>