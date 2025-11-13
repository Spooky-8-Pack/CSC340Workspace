<!-- Customer Sign Up Form -->
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
    input[type="number"],
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
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }
    button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <header>
    <h1>Create a New Profile</h1>
  </header>
  <nav>
    <a href="/home">Home</a>
  </nav>
  <main>
    <form id="new-customer" action ="/customers/signup" method="post" enctype="multipart/form-data">
      <label for="name">Name</label>
      <input type="text" id="name" name="name" placeholder="Name" />

      <label for="address">Address</label>
      <input type="text" id="address" name="address" placeholder="1234 Street" />

      <label for="email">Email</label>
      <input type="text" id="email" name="email" placeholder="Email@Example.com"/>

      <label for="password">Password</label> <!-- To Do: add security and login -->
      <input type="text" id="password" name="password" placeholder="Password"/>

      <button type="submit">Create Profile</button>
      <a href="/home">Cancel</a>
      <div id="message" role="alert"></div>
    </form>
  </main>
</body>
</html>