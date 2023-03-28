import React from 'react'

const RightSideNav = () => {
  return (
    <div style={{ 
        position: 'fixed',
        top: 60,
        right: 0,
        width: '35%',
        height:"100%",
        color:"white",
        padding: '20px',
        
        backgroundColor: '#005555',
        }}>
            <center>
        <img 
          src="src/images/login_icon.png" 
          alt="Swift Icon" 
          style={{ 
            display: 'block',
             
            margin: '0 auto',
            maxWidth: '100%',
            height: 'auto'
          }} 
        />
        </center>
        <p style={{fontFamily:"fantasy",fontSize:"20px",marginTop:"100px"}}>
        <b>SwiftPay</b> is an application that simulates the operations of a Bank with Cash & Non-Cash accounts. The simulator allows for setting up new accounts with initial balances (in different asset classes and currencies) and updating these balances in response to SWIFT messages.
        </p>
      </div>
  )
}

export default RightSideNav
