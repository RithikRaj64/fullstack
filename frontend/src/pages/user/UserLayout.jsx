import PropTypes from 'prop-types';

function UserLayout({children}) {
    return (
        <div className="user_container">
            <header>
                {/* Navbar */}
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