import React from 'react'
import mystyle from './SideBar.css'
import {SideBarData} from './SideBarData'
import CurrencyBitcoinIcon from '@mui/icons-material/CurrencyBitcoin';
import LogoutIcon from '@mui/icons-material/Logout';
const SideBar = () => {
  return (
    <div className="sidebar" >
        <br /><br /><br />
        <ul className='headList'>
            <li className='myrow'>
                <div id='myicon'><CurrencyBitcoinIcon/></div>
                <div id="mytext">SwiftPay</div>
                <></>
            </li>
        </ul> <br /><br /><br />
        <ul className='sidebarList'>
            
    {SideBarData.map((val,key)=>{
        return(
            <li key={key} className="row" onClick={()=>{
                window.location.pathname=val.link;}}>
                {""}
                <div id="icon">{val.icon}</div>{""}
                <div id="title">{val.title}</div>

            </li>
        )
    })}
    </ul>
<br /><br /><br /><br /><br /><br /><br /> <br /><br /><br />
    <ul className='headList'>
            <li className='mylogout' style={{ listStyleType: "none"}}>
                <div id='myiconlogout'><LogoutIcon/></div>
                <div id="mytextlogout">Log Out</div>
                <></>
            </li>
        </ul>

    </div>
  )
}

export default SideBar
