import React from 'react'
import './SideBar.css'
import { SideBarData } from './SideBarData'
import CurrencyBitcoinIcon from '@mui/icons-material/CurrencyBitcoin';
import LogoutIcon from '@mui/icons-material/Logout';
import { Link } from "react-router-dom";

const SideBar = () => {
    return (
        <div className="sidebar" >
            <br /><br /><br />
            <ul className='headList'>
                <li className='myrow'>
                    <div id='myicon'><CurrencyBitcoinIcon /></div>
                    <div id="mytext">SwiftPay</div>
                </li>
            </ul> <br /><br /><br />
            <ul className='sidebarList'>

                {SideBarData.map((val, key) => {
                    return (
                        <Link key={key} className="row" to={val.link}>
                            <div id="icon">{val.icon}</div>{""}
                            <div id="title">{val.title}</div>
                        </Link>
                    )
                })}
            </ul>
            <br /><br /><br /><br /><br /><br /><br /> <br /><br /><br />
            <ul className='headList'>
                <li className='mylogout' style={{ listStyleType: "none" }}>
                    <div id='myiconlogout'><LogoutIcon /></div>
                    <div id="mytextlogout">Log Out</div>
                    <></>
                </li>
            </ul>

        </div>
    )
}

export default SideBar
