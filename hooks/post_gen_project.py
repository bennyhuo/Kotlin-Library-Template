from github import Github, GithubException
import github
import subprocess
import os
import time

print("Create GitHub repository {{cookiecutter.project_name}} ...")

try:
    github = Github("{{cookiecutter.github_token}}")
    user = github.get_user()
    repo = user.create_repo("{{cookiecutter.project_name}}")

    print(f"Done. Check it on {repo.html_url}")
except GithubException as  e:
    if e.status == 422:
        repo = user.get_repo("{{cookiecutter.project_name}}")
    print(e.data['message'])
    print(e.data['errors'][0]['message'])
except Exception as e:
    print(e)
    print("Create repository '{{cookiecutter.project_name}}' failed. You can create it manually later.")


def do_shell(cmd):
    print(f"# {cmd}")
    p = subprocess.run(cmd, shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
    output = p.stdout.decode()
    if output:
        print(output)    
    return output

print("Commit init files to git repository ...")
try:
    do_shell("git init")    
    if repo and repo.clone_url:
        do_shell(f"git remote add origin {repo.clone_url}")
    
    do_shell("git add .")
    do_shell('git commit -m "init project."')
    do_shell("git push -u origin master")

    print("Done. Enjoy.")
except Exception as e:
    print(e)
    print("Error commiting files. You can handle this with shell manually later on.")