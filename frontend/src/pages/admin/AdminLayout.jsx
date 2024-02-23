import PropTypes from 'prop-types';

import Sidebar from '../../components/ui/admin/Sidebar';

function AdminLayout({children}) {
    return (
        <div className="flex flex-row min-w-screen">
            <aside>
                <Sidebar />
            </aside>
            <main>
                {children}
            </main>
        </div>
    );
}

AdminLayout.propTypes = {
    children: PropTypes.node.isRequired
}

export default AdminLayout;