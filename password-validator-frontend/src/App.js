import React from "react";
import "./PasswordForm.css"; // Import the external CSS file
import logo from "./logoHD.png"; // Ensure this is the correct path to your image

const PasswordForm = () => {
  return (
    <div className="container">
      {/* Logo */}
      <div className="logo-container">
        <img src={logo} alt="Logo" className="logo" />
      </div>
      
      {/* Password Form */}
      <div className="form-container">
        <label className="label">Create Password</label>
        <input type="password" className="input" placeholder="********" />
        
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
        <input type="password" className="input" placeholder="" />
      </div>
    </div>
  );
};

export default PasswordForm;
