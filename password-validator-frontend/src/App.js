import React, { useState } from "react";
import "./PasswordForm.css"; 
import logo from "./logoHD.png"; 

const PasswordForm = () => {
  const [password, setPassword] = useState('');
  const [retypePassword, setRetypePassword] = useState('');
  const [validationMessage, setValidationMessage] = useState('');

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();

    // Make sure the passwords match before sending to backend
    if (password !== retypePassword) {
      setValidationMessage("Passwords do not match.");
      return;
    }

    try {
      // Sending password to backend API
      const response = await fetch("http://localhost:9000/api/validatePassword", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ password: password }),
      });

      // Get the response data as JSON
      const data = await response.json();

      // Debugging: Log the response data
      console.log("Response from backend:", data);

      if (response.ok) {
        setValidationMessage("Password is valid!");
      } else {
        setValidationMessage(data.message || "Password is invalid.");
      }
    } catch (error) {
      setValidationMessage("An error occurred. Please try again.");
      console.error("Error:", error);
    }
  };

  return (
    <div className="container">
      {/* Logo */}
      <div className="logo-container">
        <img src={logo} alt="Logo" className="logo" />
      </div>

      {/* Password Form */}
      <div className="form-container">
        <label className="label">Create Password</label>
        <input 
          type="password" 
          className="input" 
          placeholder="********" 
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        
        {/* Requirements List */}
        <div className="requirements">
          <p className="bullet">● At least one numeric digit</p>
          <p className="bullet">● At least one Small/Lowercase Letter</p>
          <p className="bullet">● At least one Capital/Uppercase Letter</p>
          <p className="bullet">● Must not have space</p>
          <p className="bullet">● Must not have slash, quotation mark or apostrophe (/,",')</p>
          <p className="bullet">● At least 8 characters</p>
        </div>
        
        {/* Retype Password */}
        <label className="label">Retype password</label>
        <input 
          type="password" 
          className="input" 
          placeholder="" 
          value={retypePassword}
          onChange={(e) => setRetypePassword(e.target.value)}
        />
        
        {/* Submit Button */}
        <button onClick={handleSubmit}>Submit</button>
        
        {/* Validation Message */}
        <p>{validationMessage}</p>
      </div>
    </div>
  );
};

export default PasswordForm;
