import React from 'react'
import swiftimg from '../images/swiftPay.png'
import image2 from '../images/dollar.png'
import AttachMoneyOutlinedIcon from '@mui/icons-material/AttachMoneyOutlined';
const RightSideNav = () => {
  return (
    <div style={{ 
        position: 'fixed',
        top: 60,
        right: 0,
        width: '35%',
        height:"100%",
        color:"black",
        padding: '20px',
        
        backgroundColor: '#eceff1',
        }}>
            <center>
        <img 
          src={swiftimg} 
          alt="Swift Icon" 
          style={{ 
            display: 'block',
            margin: '0 auto',
            width: '30%',
            height: '30%',
            float:"left"
          }} 
        />
        <h1 style={{float:"left",color:"black",marginTop:"100px",marginLeft:"40px",fontSize:"50px"}}>SwiftPay</h1>
        <br />
        </center>
        <p style={{fontFamily:"fantasy",fontSize:"30px",marginTop:"190px", backgroundImage:`url(${AttachMoneyOutlinedIcon})`}}>
        <b>SwiftPay</b> is an application that simulates the operations of a Bank with Cash & Non-Cash accounts. The simulator allows for setting up new accounts with initial balances (in different asset classes and currencies) and updating these balances in response to SWIFT messages.
        </p>
      </div>
  )
}

export default RightSideNav
