import logo from './logo.svg';
import './App.css';


import Personcard from './components/PersonCard';

function App() {
  return (
    <div className="App">
      <Personcard firstName = "Doe" lastName = "Jane" age = {45} hairColor = "Black"/>
      <Personcard firstName = "Smith" lastName = "John" age = {88} hairColor = "Brown"/>
    </div>
  );
}

export default App;
