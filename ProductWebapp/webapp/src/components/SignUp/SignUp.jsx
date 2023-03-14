import React from 'react'
import myimageswift from '../images/swift_image.jpg'
import login_icon from '../images/login_icon.png'
import { Link } from '@mui/material'
import mystyle from './SignUp.css'
const SignUp = () => {
  return (
    <>
     
      <div className='main-left'>
        < img src={myimageswift}/>
      </div>
      <div className="main-right">
          <h2>SIGN UP</h2>
          <img src={login_icon}/>
          <br/>
          <br />
          <form>
             <div className="form-group" >
              <center>
                <input type="text" className="form-control" id="sign_up_f_name" aria-describedby="emailHelp" placeholder="First Name"/>
                <br />
                <input type="text" className="form-control" id="sign_up_l_name" aria-describedby="emailHelp" placeholder="Last Name"/>
                <br />
                <input type="email" className="form-control" id="sign_up_email" aria-describedby="emailHelp" placeholder="Email ID"/>
                <br />
                <input type="password"  className="form-control" id="sign_up_pw" placeholder="Password"/>
                <br />
                <input type="password"  className="form-control" id="sign_up_cpw" placeholder="Confirm Password"/>
              </center>
             </div>
      
            <div style={{float:"right"}}>
            <Link to="/" id="link_to_login" style={{marginRight:"210px"}}>Already registered? Login here</Link>
            
           </div>
    <br/><br/>
    <button type="submit" id="sign_up_button" className="btn btn-primary" style={{backgroundColor:'#005555' ,width:"100px",borderColor:"#005555"}}>Sign Up</button>

  </form>
</div>      
      </>
    
  )
}

export default SignUp
