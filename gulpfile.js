var gulp = require('gulp');
var electronDownloader = require('gulp-electron-downloader');
var less = require('gulp-less');
var path = require('path');

gulp.task('less', function () {
    return gulp.src('./app/less/**/*.less')
        .pipe(less({
            paths: [ path.join(__dirname, 'less', 'includes') ]
        }))
        .pipe(gulp.dest('./app/css'));
});

gulp.task('download-electron', function(cb){
    electronDownloader(cb);
});

gulp.task('default', function() {
    gulp.watch('./app/less/**/*.less', ['less']);
});
