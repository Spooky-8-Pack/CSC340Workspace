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
        <main id="content">
         <h2>${customer.name}</h2>
              <div class="customer-details">
                <p><strong>Address:</strong> ${customer.address}</p>
                <p><strong>Email:</strong> ${customer.email} years</p>
                <a href="/customers/${customer.customerId}/update">Update Your Profile</a> 
                <a href="/customers/${customer.customerId}/delete">Delete Your Profile</a> 
                <a href="/home">Home</a>
              </div>     
        </main>
    </body>
</html>