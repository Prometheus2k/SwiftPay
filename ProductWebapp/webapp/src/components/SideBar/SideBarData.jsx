import React from 'react'
import HouseIcon from '@mui/icons-material/House';
import ReplyIcon from '@mui/icons-material/Reply';
import SpeakerNotesIcon from '@mui/icons-material/SpeakerNotes';
import AccountBalanceIcon from '@mui/icons-material/AccountBalance';
import PersonPinIcon from '@mui/icons-material/PersonPin';
export const SideBarData = [
  {
    title: "Dashboard",
    icon: <HouseIcon />,
    link: "/"
  },
  {
    title: "Transfer",
    icon: <ReplyIcon />,
    link: "/home"
  },
  {
    title: "Transactions",
    icon: <SpeakerNotesIcon />,
    link: "/transactionhistory"
  },
  {
    title: "Bank Details",
    icon: <AccountBalanceIcon />,
    link: "/addbankacc"
  },
  {
    title: "My Profile",
    icon: <PersonPinIcon />,
    link: "/userprofile"
  }

];


