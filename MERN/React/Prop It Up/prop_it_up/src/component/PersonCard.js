import React, { Component } from 'react';
    
    
class Personcard extends Component {
    render() { 
    return( 
        <div>
            <h1>{ this.props.firstName } { this.props.lastName }</h1>
            <h5>Age: { this.props.age }</h5>
            <h5>Hair Color: { this.props.hairColor }</h5>
        </div>
    );    
}
}
    
export default Personcard;