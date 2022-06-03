
import { Container, Nav } from 'react-bootstrap'
import Navbar from 'react-bootstrap/Navbar'
export const Header = ()=>{
    return (<>
        <Navbar bg="dark" variant="dark">
            <Container>
                <Nav className='me-auto'>
                    <Nav.Link href={'/home'}>Home</Nav.Link>
                    <Nav.Link href={'/products'}>Products</Nav.Link>
                </Nav>
            </Container>
        </Navbar>
    </>)
}