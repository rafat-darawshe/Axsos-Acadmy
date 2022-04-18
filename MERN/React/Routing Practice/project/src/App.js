import './App.css';
import {
  BrowserRouter,
  Switch,
  Route
} from "react-router-dom";
import Number from './component/Number';
import Home from './component/Home';
import Word from './component/Word';

function App() {
  return (
    <BrowserRouter>
    <Switch>
    <Route path="/home">
        <Home/>
      </Route>
      <Route exact path="/:number">
        <Number/>
      </Route>
      <Route path="/:word/:color/:backgroundColor">
        <Word/>
      </Route>
    </Switch>
  </BrowserRouter>
  );
}

export default App;