import React from 'react'
import myimageswift from '../images/swift_image.jpg'
import login_icon from '../images/login_icon.png'
import { Link } from '@mui/material'
import { NavLink } from 'react-router-dom'
import mystyle from './Login.css'
const Login = () => {
  return (
    <>
      <div className='main-left'>
        < img src={myimageswift}/>
      </div>
      <div  className='main-right'>
        <h2 >SIGN IN</h2>
        <img src={login_icon}/>
        <br/>
        <br />
      
        <form>
          <div className="form-group">
            <center>
            <input type="email" className="form-control" id="login_email" aria-describedby="emailHelp" placeholder="Enter email"/>
           <br />
            <input type="password" className="form-control" id="login_pw" placeholder="Password"/>
            </center>
          </div>
          <div className="form-check">
            <input type="checkbox" id="login_checkbox"/>
            <label className="form-check-label" for="exampleCheck1">&nbsp;Remember Me</label>
            <Link to="/changepw" id="link_to_forgotpw">Forgot Password?</Link>
          </div> <br /><br />
          <div className='form-link-new-account'>
            <Link to="/signup"  id="link_to_create_new_account">Create an Account</Link>
          </div>
  <br/><br/>
  <button type="submit" className="btn btn-primary" id='login_button' style={{backgroundColor:'#005555' ,width:"100px",borderColor:"#005555"}}>Log In</button>

</form>
</div>      

 </>
    
  )
}

export default Login
