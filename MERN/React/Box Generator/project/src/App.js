import logo from './logo.svg';
import './App.css';
import {useState} from "react";

import Form from './component/Form';
import Box from './component/Box';



function App() {
  const [boxes, setBoxes] = useState([]);
  const setBoxesFun= (color)=>{
    setBoxes([...boxes, color]);
  }
  return (
    <div className="App">
      <Form myFun = {setBoxesFun}/>
      <Box myBoxes={boxes}/>
    </div>
  );
}

export default App;
