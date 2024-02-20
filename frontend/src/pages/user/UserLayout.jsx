import PropTypes from 'prop-types';

import Navbar from '../../components/ui/Navbar';

function UserLayout({children}) {
    return (
        <div className="user_container">
            <header>
                {/* Navbar */}
                <Navbar />
            </header>
            <main>
                {children}
            </main>
            <footer>
                {/* Footer */}
            </footer>
        </div>
    );
}

UserLayout.propTypes = {
    children: PropTypes.node.isRequired
};

export default UserLayout;