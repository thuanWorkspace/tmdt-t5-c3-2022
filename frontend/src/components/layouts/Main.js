import React from 'react'

function Main({ children }) {
    return (
        <>
            <header>header</header>
            <div className='content'>
                {children}
            </div>
            <footer>footer</footer>
        </>
    )
}

export default Main