<!-- Customer Sign In Form -->
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Add New Customer</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0; padding: 0;
      background: #f9f9f9;
    }
    main {
      max-width: 600px;
      margin: 2em auto;
      background: white;
      padding: 2em;
      border-radius: 8px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    }
    form {
      display: flex;
      flex-direction: column;
    }
    label {
      margin-top: 1em;
      font-weight: bold;
      color: #333;
    }
    input[type="text"],
    textarea {
      padding: 0.5em;
      font-size: 1em;
      margin-top: 0.3em;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
    textarea {
      resize: vertical;
    }
    button {
      margin-top: 2em;
      padding: 0.75em;
      font-size: 1em;
      background-color: #FFB71B;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }
    button:hover {
      background-color: #fbd688;
    }
  </style>
</head>
<!-- Currently password does nothing, the login is email based. -->
<body>
  <h1 style="text-align: center;"> Sign In </h1>
  <main>
    <form id="new-customer" action ="/customers/signin/form" method="get" enctype="multipart/form-data">

      <label for="email">Email</label>
      <input type="text" id="email" name="email" placeholder="Email@Example.com"/>

      <label for="password">Password</label> <!-- To Do: add security and login -->
      <input type="text" id="password" name="password" placeholder="Password"/>

      <button type="submit">Sign In</button>
      <a href="/home">Cancel</a>
      <div id="message" role="alert"></div>
    </form>
  </main>
</body>
</html>