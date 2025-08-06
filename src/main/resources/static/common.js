// Common header and navigation functionality
function loadHeaderAndNav() {
    // Create header HTML
    const headerHTML = `
        <div class="header">
            <div class="logo">
                <i class="fas fa-graduation-cap"></i>
                <span>Campus1</span>
            </div>
            <div class="date-time">
                <i class="fas fa-check-circle"></i>
                <span id="current-datetime"></span>
            </div>
        </div>
    `;

    // Create sidebar HTML
    const sidebarHTML = `
        <div class="sidebar">
            <h2>Admin Dashboard</h2>
            <a href="admin_profile.html"><i class="fas fa-user-shield"></i> Admin Profile</a>
            <a href="resume_users_data.html"><i class="fas fa-file-alt"></i> Users Data</a>
            <a href="logout.html"><i class="fas fa-sign-out-alt"></i> Logout</a>
        </div>
    `;

    // Insert header at the beginning of body
    document.body.insertAdjacentHTML('afterbegin', headerHTML);
    
    // Insert sidebar after header
    const header = document.querySelector('.header');
    header.insertAdjacentHTML('afterend', sidebarHTML);

    // Update date and time
    updateDateTime();
    setInterval(updateDateTime, 60000);
}

// Function to update date and time
function updateDateTime() {
    const now = new Date();
    const options = {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit',
        hour: '2-digit',
        minute: '2-digit',
        hour12: true,
        timeZone: 'Asia/Kolkata'
    };
    const dateTimeString = now.toLocaleDateString('en-US', options) + ' IST';
    const dateTimeElement = document.getElementById('current-datetime');
    if (dateTimeElement) {
        dateTimeElement.textContent = dateTimeString;
    }
}

// Load header and navigation when DOM is ready
document.addEventListener('DOMContentLoaded', function() {
    // Check if user is logged in
    if (localStorage.getItem('isLoggedIn') !== 'true') {
        // User is not logged in, redirect to login page
        window.location.href = 'login.html';
        return;
    }
    
    // Load header and navigation
    loadHeaderAndNav();

});