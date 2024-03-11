import PropTypes from 'prop-types';

import Sidebar from '../../components/ui/institute/Sidebar';

function InstituteLayout({children}) {
    return (
        <div className="flex flex-row min-w-screen">
            <aside className='fixed'>
                <Sidebar />
            </aside>
            <main className="ml-64 flex-grow">
                {children}
            </main>
        </div>
    );
}

InstituteLayout.propTypes = {
    children: PropTypes.node.isRequired
}

export default InstituteLayout;