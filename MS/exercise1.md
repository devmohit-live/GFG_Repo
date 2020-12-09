#

> Write the following into that file, one line at a time:
> #!/bin/sh
> curl --head --silent https://missing.csail.mit.edu

```bash
cat >/etc/myconfig.conf <<EOL
#!/bin/sh
curl --head --silent https://missing.csail.mit.edu
EOL
```

> 10. Use | and > to write the “last modified” date output by semester into a file called last-modified.txt in your home directory.

```bash
ls -l semester | cut -d \ -f6-9 > last-modified.txt
```
