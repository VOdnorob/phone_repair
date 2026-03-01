import { useState } from 'react'

import './App.css'
import Client from "./client/Client.jsx";

function App() {
  const [count, setCount] = useState(0)


  return (
    <>
        <div>

            <Client></Client>
        </div>
    </>
  )
}
export default App
